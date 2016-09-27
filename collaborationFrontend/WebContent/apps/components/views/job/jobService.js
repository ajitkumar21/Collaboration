var jobService=angular.module('controllerJobservice',[]);
jobService.factory('JobService', ['$http','$q', function($http,$q){
     var REST_SERVICE_URI='http://localhost:8080/collaborationBackend/jobs/';
     
     var factory={
     	fetchAllJob: fetchAllJob,
     	createJob:createJob,
        updateJob:updateJob,
        deleteJob:deleteJob
     };
	return factory;

	function fetchAllJob(){
		var deferred = $q.defer();
        $http.get(REST_SERVICE_URI)
            .then(
            function (response) {
                deferred.resolve(response.data);
            },
            function(errResponse){
                console.error('Error while fetching Jobs');
                deferred.reject(errResponse);
            }
        );
        return deferred.promise;
	}

	function createJob(job) {
        var deferred = $q.defer();
        $http.post(REST_SERVICE_URI, job)
            .then(
            function (response) {
                deferred.resolve(response.data);
            },
            function(errResponse){
                console.error('Error while creating Job');
                deferred.reject(errResponse);
            }
        );
        return deferred.promise;
    }
 
 
    function updateJob(job, job_id) {
        var deferred = $q.defer();
        $http.put(REST_SERVICE_URI+job_id, job)
            .then(
            function (response) {
                deferred.resolve(response.data);
            },
            function(errResponse){
                console.error('Error while updating job');
                deferred.reject(errResponse);
            }
        );
        return deferred.promise;
    }
 
    function deleteJob(job_id) {
        var deferred = $q.defer();
        $http.delete(REST_SERVICE_URI+job_id)
            .then(
            function (response) {
                deferred.resolve(response.data);
            },
            function(errResponse){
                console.error('Error while deleting job');
                deferred.reject(errResponse);
            }
        );
        return deferred.promise;
    }
}]);