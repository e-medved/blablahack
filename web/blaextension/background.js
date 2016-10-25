//script один для всего расширения, является фоновым когда срабатывает ?

chrome.runtime.onMessage.addListener(function(message,sender,sendResponse){
    if (message.action == "sendUsers")
        sendUsers(message);
    if (message.action == "getUser")
        getUserFromServerByHash(message.userID);
});

var baseServiceUrl = "http://127.0.0.1:8080/";

function sendUsers(message){
    $.ajax({
        url: baseServiceUrl + "users",
        type: 'post',
        data: JSON.stringify({users: message.passengers}),
        contentType: 'application/json',
        dataType: 'json'
    });
}

function getUserFromServerByHash(hashID){
    $.ajax({
        url: baseServiceUrl + "users/" + hashID,
        type: 'get',
        contentType: 'application/json',
        dataType: 'json'
    });

}

function saveTripIdToLocalStorage(){

}