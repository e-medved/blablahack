//скрипт работы непосредственно с кодом страницы, имеет доступ к DOM
//выполнение регламентируется в манифест файле с помощью спец параметров
//https://www.blablacar.ru/dashboard/trip-offers/inactive


var driverData;
var passengersData;
users = [];

function fillData() {

  var url = window.location.pathname;
  var tripId, blaUserHash, phone;

  //поиск на странице актуальной поездки (не совершенная на данный момент)
  if (url.indexOf('poezdka') !== -1) {
    tripId = url.split('-').slice(-1)[0];

    $('.align-center.u-lightestGreen-bg.cell-separator').each(function () {
      blaUserHash = $(this).find('a').attr('href').split('/').slice(-1)[0];
      phone = $(this).find('.phone').text();

      addUser(blaUserHash, phone);
    });

    //поиск id водителя
    getDriverID();
  }

  //поиск на странице прошедшей поездки (совершенная в недалеком прошлом)
  if (url.indexOf('trip-offer') !== -1) {
    tripId = url.split('/')[2];

    //todo slice refactor
    $('.div.col-50.u-left').each(function () {
      blaUserHash = $(this).find(".picture").attr('href').split('/').slice(-1)[0];
      phone = $(this).find(".mobile").text();

      addUser(blaUserHash, phone);
    });
  }

  if (users.length > 0)
    passengersData = {
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

function getDriverID() {
  var driverUrl = $('.ProfileCard').find('a').first().attr('href');
  var driverHash = driverUrl.split('/').slice(-1)[0];

  if (driverHash)
    driverData = {
      action: "getUser",
      userID: driverHash
    };
}


fillData();


if (passengersData)
  chrome.runtime.sendMessage(passengersData, function (response) {
    console.log("sended to server");
  });

if (driverData)
  chrome.runtime.sendMessage(driverData, function (response) {
    console.log("sended to server");
  });