var job=angular.module('collaborationAppJob',['controllerJobservice','ngRoute']);
job.controller('jobController',[ '$scope','JobService','$http',function($scope,JobService,$http){
	var self=this;
	self.job={job_id:'',title:'',description:''}
	self.jobs=[];

	self.submit = submit;
	self.edit=edit;
	self.remove=remove;
	self.reset=reset;


	fetchAllJob();
	function fetchAllJob(){
		JobService
		.fetchAllJob()
		.then(function(data){
			self.jobs=data;
		},function (errResponse) {
			console.error('Error while fetching the jobs');
		}
		);
	}

	function createJob(job){
		JobService
		.createJob(job)
		.then(
			fetchAllJob,
			function(errResponse){
				console.error('Error while creating job');
			}
			);
	}

	function updateJob(job, job_id){
		JobService
		.updateJob(job, job_id)
		.then(
			fetchAllJob,
			function(errResponse){
				console.error('Error while updating job');
			}
			);
	}

	function deleteJob(job_id){
		JobService
		.deleteJob(job_id)
		.then(
			fetchAllJob,
			function(errResponse){
				console.error('Error while deleting job');
			}
			);
	}
	function submit() {
		if(self.job.job_id===''){
			console.log('Saving New job', self.job);
			createJob(self.job);
		}else{
			console.log('Job updated with job_id ', self.job.job_id);
			updateJob(self.job, self.job.job_id);
		}

		reset();
	}
	function edit(job_id){
		console.log('id to be edited', job_id);
		for(var i = 0; i < self.jobs.length; i++){
			if(self.jobs[i].job_id === job_id) {
				self.job= angular.copy(self.jobs[i]);
				break;
			}
		}
	}
	function remove(job_id){
		console.log('id to be deleted', job_id);
        if(self.job.job_id === job_id) {//clean form if the job to be deleted is shown there.
        	reset();
        }
        deleteJob(job_id);
    }
    function reset(){
    	self.job={job_id:'',description:'',title:''};
        $scope.myForm.$setPristine(); //reset Form
    }
    
}]);