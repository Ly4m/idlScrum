angular.module('scrumboard').controller('LoginController', function () {

    this.credentials = {
        user: '',
        password: ''
    };

    this.signIn = function () {

        console.debug("COUCOU");


        $http.post('/signin', this.credentials).success(data, function () {
            console.debug(JSON.stringify(data));
        }).error(data, function () {
            console.debug(JSON.stringify(error));
        });

    }

});