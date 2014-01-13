package daten;
import java.util.Date;

public class Student extends Person implements Comparable<Student> {

        public Student(String firstName, String lastName, Date gebDat) {
                this(firstName, lastName, false, gebDat);
        }

        public Student(String firstName, String lastName, boolean selfEntitled, Date gebDat) {
                super(firstName, lastName);
                setSelfEntitled(selfEntitled);
                setBirthDate(gebDat);
        }

        private boolean selfEntitled;
        private Date birthDate; // TODO add getter,setter,Constructors

        public Date getBirthDate() {
			return birthDate;
		}

		public void setBirthDate(Date birthDate) {
			if(birthDate == null)
				throw new IllegalArgumentException();
			else
				this.birthDate = birthDate;
		}

		public void setSelfEntitled(boolean selfEntitled) {
                this.selfEntitled = selfEntitled;
        }

        @Override
        public int compareTo(Student o) {
                int result = 0;

                
                // TODO implement meaningful unit tests
                if ((result = getLastName().compareTo(o.getLastName())) == 0) {
                        if ((result = getFirstName().compareTo(o.getFirstName())) == 0) {
                                result = getBirthDate().compareTo(o.getBirthDate()); // ODO change to
                                                                                                                        // getter after
                                                                                                                        // implementation
                        }
                }
                return result;
        }

        @Override
        public String toString() {
            String erg = getFirstName()+" "+getLastName()+", born on "+birthDate.toString();    
        	return erg;
                
        }
}