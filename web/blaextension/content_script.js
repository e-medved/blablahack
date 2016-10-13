//скрипт работы непосредственно с кодом страницы, имеет доступ к DOM
//выполнение регламентируется в манифест файле с помощью спец параметров
//https://www.blablacar.ru/dashboard/trip-offers/inactive

// $.get("https://www.blablacar.ru/dashboard/trip-offers/inactive", function(data) {
//     // html = $.parseHTML(data);
//
//     $(data).find(".col-50 u-left").each(function(user){
//         var blaUserHash = user.find(".picture").attr("href");
//         var phone = user.find(".mobile").text();
//         // do stuff
//     });
//
//     alert("Data Loaded: " + $(data).find(".passengers blue no-bold").attr('href'));
//     console.log($(data).find(".col-50 u-left").attr('href'));
// });


var data;
users = [];

function fillPassengers() {

    var url = window.location.pathname;
    var tripId, blaUserHash, phone;

    //поиск на странице актуальной поездки (не совершенная на данный момент)
    if (url.indexOf('poezdka') !== -1){
        tripId = url.split('-').slice(-1)[0];

        $('align-center.u-lightestGreen-bg.cell-separator').each(function () {
            blaUserHash = $(this).find('a').attr('href');
            phone = $(this).find('.phone').text();

            addUser(blaUserHash, phone);
        }
    }

    //поиск на странице прошедшей поездки (совершенная в недалеком прошлом)
    if (url.indexOf('trip-offer') !== -1){
        tripId = url.split( '/' )[2];

        $("div.col-50.u-left").each(function () {
            blaUserHash = $(this).find(".picture").attr('href');
            phone = $(this).find(".mobile").text();

            addUser(blaUserHash, phone);
        });
    }

    data = {
        action: "sendUsers",
        trip: tripId,
        passengers: users
    }
}

function addUser(userHash, phone) {
    if (userHash && phone){
        if (user.every(function(val){
            return val.blahash+"|"+val.phone !== userHash+"|"+phone;
        })){
            user = {
                'blahash': blaUserHash,
                'phone': phone
            };
            users.push(user);
        }
    }
}


fillPassengers();

chrome.runtime.sendMessage(data, function(response) {
    console.log("sended to server");
});