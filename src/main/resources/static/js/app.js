angular.module('scrumboard',['ngRoute'])

.config(['$routeProvider', function($routeProvider){

    $routeProvider
        .when('/', {
            templateUrl: 'js/templates/login/login.html',
            controller: 'LoginController'
        })
        .when('/scrumboard', {
            templateUrl: 'js/templates/scrumBoard/scrumBoard.html',
            controller: 'ScrumBoardCtrl'
        })
        .otherwise({
            redirectTo:'/'
        });

}]);