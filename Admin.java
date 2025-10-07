package LearningOOP.MovieTickets;

public class Admin {
        private String name;
        private String password;

        Admin()
        {
            name = "Admin";
            password = "1234";
        }

        public String getName() {
            return name;
        }

        public String getPassword() {
            return password;
        }
}
