/**
 * @ngdoc directive
 * @name scrumboard:sbNavbar
 *
 * @description
 *
 *
 * @restrict E
 * */
angular.module('scrumboard')
    .directive('sbNavbar', function () {
        return {
            restrict: 'E',
            templateUrl: 'templates/navBar/navBar.html',
            link: function (scope, elem, attr) {

            },
            scope: {
                current: "="
            },
            controller: function ($scope, $http) {
                $scope.refresh = function () {

                    $http.get("/test/refresh").success(function (data) {

                    });
                };
            }
        };
    });
