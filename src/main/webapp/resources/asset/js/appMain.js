angular.module('healthSutra', []).controller('appCtrl', ['$scope', function ($scope) {
    $scope.master = {};

    $scope.showLoginDiv = function () {
        alert("show login div");
    };

    $scope.login = function () {
        alert("login clicked");
    };
}]);

/*
 (function () {
 var app = angular.module('healthSutra', []);

 app.controller('appCtrl', function () {
 showLoginDiv = function () {
 alert("show login div");
 };

 login = function () {
 alert("login clicked");
 };

 })
 })();

 */