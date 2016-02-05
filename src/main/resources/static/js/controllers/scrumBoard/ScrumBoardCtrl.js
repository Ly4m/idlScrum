angular.module('scrumboard')
    .controller('ScrumBoardCtrl', function ($scope, $http, $location) {

        $scope.stories = [
        {text: 'un'},
        {text: 'deux'},
        {text: 'trois'},
        {text: 'quatre'}
        ]
    });