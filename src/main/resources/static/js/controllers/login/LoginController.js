angular.module('scrumboard')
    .controller('LoginController', function ($scope, $http, $location) {

        this.formulaireRecherche = {
            login: '',
            password: ''
        };

        $scope.signIn = function () {

            $http.post('/search', this.formulaireRecherche).success(function (data) {

                if (data) {
                    $location.path('/scrumboard');
                } else {
                    //todo
                }
            });
        }
    });