package Baazi;

public class Account implements OnlineAccount ,Comparable<Account>{
    Integer noOfRegularMovies;
    Integer noOfExclusiveMovies;
    String ownerName;
    public Account(Integer noOfRegularMovies,Integer noOfExclusiveMovies,String ownerName){
        this.noOfExclusiveMovies=noOfExclusiveMovies;
        this.noOfRegularMovies=noOfRegularMovies;
        this.ownerName=ownerName;
    }

    public int monthlyCost(){
        return basePrice+noOfRegularMovies*regularMoviePrice+noOfExclusiveMovies*exclusiveMoviePrice;
    }

    @Override
    public int compareTo(Account o) {
        return this.monthlyCost()-o.monthlyCost();
    }

    @Override
    public String toString() {
        return "Account{" +
                "ownerName='" + ownerName + '\'' +
                "monthlyCose='" + this.monthlyCost() + '\'' +
                '}';
    }
}
