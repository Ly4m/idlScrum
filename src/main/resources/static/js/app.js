angular.module('scrumboard',[])

.config(function($routeProvider){

    $routeProvider.when('/', {
      templateUrl: 'templates/login/login.html',
        controller: 'LoginController',
        controllerAs : 'loginCtlr'
    })

});
