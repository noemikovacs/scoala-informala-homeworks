/*
 * this class checks if the seniority in the Company
 */
import java.util.Comparator;


	class YearAtComp implements Comparator<Empl>{
		 
	    public int compare(Empl e1, Empl e2) {
	        if(e1.getYearAtCompany() < e2.getYearAtCompany()){
	            return 1;
	        } else {
	            return -1;
	        }
	    }
	}

