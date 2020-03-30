package ques2;

/**
 * The Class Job.
 */
public class Job {
	
	/** The job name. */
	private String jobName;
	
	/** The priority. */
	private int priority;
	
	/**
	 * Instantiates a new job.
	 *
	 * @param jobName the job name
	 * @param priority the priority
	 */
	Job(String jobName, int priority)
	{
		this.jobName = jobName;
		this.priority = priority;
	}

	/**
	 * Gets the job name.
	 *
	 * @return the job name
	 */
	public String getJobName() {
		return jobName;
	}

	/**
	 * Gets the priority.
	 *
	 * @return the priority
	 */
	public int getPriority() {
		return priority;
	}
}