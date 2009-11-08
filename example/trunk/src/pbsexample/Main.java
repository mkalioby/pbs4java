package pbsexample;

import java.util.ArrayList;
import pbsTorque.Job;


/**
 *
 * @author Mohamed M. El-Kalioby
 * @since Nov. 8 ,2009
 * @Version 1.0
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        if (args.length>0)
            AddJobs();
        else
        SearchJobs("Job_1",true);
    }

    /**
     *
     * @param Name : query
     * @param ExactMatch : found similar jobs
     * This methods show how to search for a Job
     */
    static void SearchJobs(String Name, Boolean ExactMatch)
    {
        try
        {
            String[] found=  Job.SearchJobsByName(Name,ExactMatch);
            if (found!=null)
            {
                Job j ;
                for (int i=0; i< found.length; i++)
                {

                    System.out.println("Found: " + found[i]);
                    j=Job.getJobById(found[i].trim());
                    System.out.println( j.toString());
                    System.out.println("\n");
                    //System.out.println("Duration" + j.Duration());
                    System.out.println();
                }

            }
            else
                System.out.println("No Job Found");
        }
        catch (Exception ex)
        {
            System.out.println("ERR: " + ex.getMessage());
        }

    }
/**
 * This shows how to queue Jobs
 */
    static void AddJobs()
    {
        ArrayList<String> IDs=null;
       String ID;
       pbsTorque.Job j;
        for (int i=1; i<6; i++)
        {

        j = new Job("Job_" + i , "/home/mohamed/sleep.sh");

        /**
         Run on a certain node.
         */

        //j.setNodes("mk");
        try
        {
   //         if (IDs != null)
         /**
         Run after another job.
         */
   //             j.setAfterOK(IDs);
   //         else
                IDs=  new ArrayList<String>();
            ID = j.queue().trim();
            IDs.add(ID);

        System.out.println( "Job ID : " + ID );
        }
        catch(Exception exp )
        {
           System.out.println(exp.getMessage());
           break;
        }
        }
    }

}