package Baazi;

public interface OnlineAccount {

    int basePrice = 0;
    int regularMoviePrice = 0;
    int exclusiveMoviePrice = 0;

    int compareTo(Account o);
}
