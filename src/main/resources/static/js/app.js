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
            .when('/stories', {
                templateUrl: '../templates/stories/stories.html',
                controller: 'StoriesCtrl'
            })
            .when('/tasks', {
                templateUrl: '../templates/tasks/tasks.html',
                controller: 'TasksCtrl'
            })
            .otherwise({
                redirectTo: '/'
            });

    }]);