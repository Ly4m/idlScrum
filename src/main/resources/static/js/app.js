angular.module('scrumboard', ['ngRoute'])
    .config(['$routeProvider', function ($routeProvider) {

        $routeProvider
            .when('/', {
                templateUrl: 'templates/login/login.html',
                controller: 'LoginController'
            })
            .when('/scrumboard', {
                templateUrl: '../templates/scrumBoard/scrumBoard.html',
                controller: 'ScrumBoardCtrl'
            })
            .otherwise({
                redirectTo: '/'
            });

    }]);