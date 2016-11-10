//скрипт работы непосредственно с кодом страницы, имеет доступ к DOM
//выполнение регламентируется в манифест файле с помощью спец параметров
//https://www.blablacar.ru/dashboard/trip-offers/inactive


var driverData;
var usersData;
users = [];

function fillData() {

  var url = window.location.pathname;
  var previousURL = document.referrer;
  var tripId;

  //поиск на странице актуальной поездки (не совершенная на данный момент)
  if (url.indexOf('poezdka') !== -1) {
    searchInActualTrip();

    //поиск id водителя
    if (previousURL.indexOf('poisk-poputchikov') !== -1)
      getDriverID();
  }

  //поиск на странице прошедшей поездки (совершенная в недалеком прошлом)
  if (url.indexOf('trip-offer') !== -1) {
    searchInPastTrip();
  }

  //поиск на странице бронирования
  if (url.indexOf('manage-my-booking') !== -1){
    searchInBookingPage();
  }

  if (users.length > 0)
    usersData = {
      action: "sendUsers",
      trip: tripId,
      passengers: users
    };
}

function addUser(userHash, phone) {
  if (userHash && phone) {
    if (users.every(function (val) {
        return val.blahash + "|" + val.phone !== userHash + "|" + phone;
      })) {
      user = {
        'blaHash': userHash,
        'phone': phone
      };
      users.push(user);
    }
  }
}

function searchInActualTrip(){
  $('.align-center.u-lightestGreen-bg.cell-separator').each(function () {
    blaUserHash = getUserIDFromUrl($(this).find('a').attr('href'));
    phone = $(this).find('.phone').text();

    addUser(blaUserHash, phone);
  });
}

function searchInPastTrip(){
  $('.col-50.u-left').each(function () {
    if (!$(this).find('.picture').attr('href'))
      return true;
    blaUserHash = getUserIDFromUrl($(this).find('.picture').attr('href'));
    phone = $(this).find(".mobile").text();

    addUser(blaUserHash, phone);
  });
}

function searchInBookingPage() {
  var driverHash = getUserIDFromUrl($('.driver-info').find('a').first().attr('href'));
  var phone = $('.driver-info').find('.phone').first().text();

  addUser(driverHash, phone);
}

function getDriverID() {
  var driverHash = getUserIDFromUrl($('.ProfileCard').find('a').first().attr('href'));

  if (driverHash)
    driverData = {
      action: "getUser",
      userID: driverHash
    };
}

function getUserIDFromUrl(url){
  return url.split('/').slice(-1)[0];
}

fillData();


if (usersData)
  chrome.runtime.sendMessage(usersData, function (response) {
    console.log("sended to server");
  });

if (driverData)
  getDriverPhone();

function getDriverPhone() {
  var baseServiceUrl = "http://127.0.0.1:8080";
  var apiUrl = baseServiceUrl + '/users?id=' + driverData.userID;

  $.get(apiUrl, function (html) {
    $('body').append(html)
  });
}