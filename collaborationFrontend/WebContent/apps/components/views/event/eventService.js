var eventService=angular.module('controllerEventservice',[]);
eventService.factory('EventService', ['$http','$q', function($http,$q){
     var REST_SERVICE_URI='http://localhost:8080/collaborationBackend/events/';
     
     var factory={
     	fetchAllEvent: fetchAllEvent,
     	createEvent:createEvent,
        updateEvent:updateEvent,
        deleteEvent:deleteEvent
     };
	return factory;

	function fetchAllEvent(){
		var deferred = $q.defer();
        $http.get(REST_SERVICE_URI)
            .then(
            function (response) {
                deferred.resolve(response.data);
            },
            function(errResponse){
                console.error('Error while fetching Events');
                deferred.reject(errResponse);
            }
        );
        return deferred.promise;
	}

	function createEvent(event) {
        /*
        var deferred = $q.defer();
        $http.post(REST_SERVICE_URI, event)
            .then(
            function (response) {
                deferred.resolve(response.data);
            },
            function(errResponse){
                console.error('Error while creating Event');
                deferred.reject(errResponse);
            }
        );
        return deferred.promise;
        */
         var deferred = $q.defer();
    $http.post(REST_SERVICE_URI,event,{
        transformRequest : angular.identity,
        headers : {
            'Content-Type' : undefined
        }
    })
    .then(
        function (response) {
            deferred.resolve(response.data);
        },
        function(errResponse){
            console.error('Error while creating Event');
            deferred.reject(errResponse);
        }
        );
    return deferred.promise;
    }
 
 
    function updateEvent(event, event_id) {
        var deferred = $q.defer();
        $http.put(REST_SERVICE_URI+event_id, event)
            .then(
            function (response) {
                deferred.resolve(response.data);
            },
            function(errResponse){
                console.error('Error while updating event');
                deferred.reject(errResponse);
            }
        );
        return deferred.promise;
    }
 
    function deleteEvent(event_id) {
        var deferred = $q.defer();
        $http.delete(REST_SERVICE_URI+event_id)
            .then(
            function (response) {
                deferred.resolve(response.data);
            },
            function(errResponse){
                console.error('Error while deleting event');
                deferred.reject(errResponse);
            }
        );
        return deferred.promise;
    }
}]);