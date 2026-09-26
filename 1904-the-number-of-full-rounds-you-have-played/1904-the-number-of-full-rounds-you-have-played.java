class Solution {
    public int numberOfRounds(String loginTime, String logoutTime) {
        int logInh = Integer.parseInt(loginTime.substring(0 , 2));
        int logInm = Integer.parseInt(loginTime.substring(3 , 5));


        int logOuth = Integer.parseInt(logoutTime.substring(0 , 2));
        int logOutm = Integer.parseInt(logoutTime.substring(3 , 5));

        int login = logInh * 60 + logInm;
        int logout = logOuth * 60 + logOutm;

        if(logout < login){
            logout += 24*60;
        }

        login = ((login + 14)/15)*15;

        logout = ((logout)/15)*15;

        return Math.max(0 , (logout-login)/15);
    }
}