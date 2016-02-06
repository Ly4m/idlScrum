angular.module('scrumboard')
    .controller('ScrumBoardCtrl', function ($scope, $http, $location) {

        $scope.stories = [
            {
                text: 'As a user I want to do things',
                todoes: [
                    {
                        title: 'a faire',
                        description: 'super description'
                    },
                    {
                        title: 'must do',
                        description: 'this is a test'
                    }
                ]
            },
            {text: 'deux'},
            {text: 'trois'},
            {text: 'quatre'}
        ]

    });