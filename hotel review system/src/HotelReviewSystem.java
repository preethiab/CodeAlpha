import java.util.*;
import java.util.stream.Collectors;

class Review {
    private String username;
    private String comment;
    private int rating; // rating out of 5
    private Date date;

    public Review(String username, String comment, int rating) {
        this.username = username;
        this.comment = comment;
        this.rating = rating;
        this.date = new Date(); // current date
    }

    public String getUsername() {
        return username;
    }

    public String getComment() {
        return comment;
    }

    public int getRating() {
        return rating;
    }

    public Date getDate() {
        return date;
    }

    @Override
    public String toString() {
        return "Review by " + username + ": " + comment + " (Rating: " + rating + ", Date: " + date + ")";
    }
}

class Hotel {
    private String name;
    private List<Review> reviews;

    public Hotel(String name) {
        this.name = name;
        this.reviews = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public List<Review> getReviews() {
        return reviews;
    }

    public void addReview(Review review) {
        reviews.add(review);
    }

    public List<Review> sortReviewsByRating(boolean ascending) {
        Comparator<Review> comparator = Comparator.comparingInt(Review::getRating)
                                                  .thenComparing(Review::getDate);
        if (!ascending) {
            comparator = comparator.reversed();
        }
        return reviews.stream()
                .sorted(comparator)
                .collect(Collectors.toList());
    }

    public List<Review> sortReviewsByDate(boolean ascending) {
        Comparator<Review> comparator = Comparator.comparing(Review::getDate);
        if (!ascending) {
            comparator = comparator.reversed();
        }
        return reviews.stream()
                .sorted(comparator)
                .collect(Collectors.toList());
    }

    public List<Review> filterReviewsByRating(int minRating) {
        return reviews.stream()
                .filter(review -> review.getRating() >= minRating)
                .collect(Collectors.toList());
    }

    @Override
    public String toString() {
        return "Hotel: " + name + " (" + reviews.size() + " reviews)";
    }
}

public class HotelReviewSystem {
    private List<Hotel> hotels;

    public HotelReviewSystem() {
        this.hotels = new ArrayList<>();
    }

    public void addHotel(Hotel hotel) {
        hotels.add(hotel);
    }

    public Hotel getHotel(String name) {
        for (Hotel hotel : hotels) {
            if (hotel.getName().equalsIgnoreCase(name)) {
                return hotel;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        HotelReviewSystem system = new HotelReviewSystem();

        Hotel hotel1 = new Hotel("Hotel HMR");
        Hotel hotel2 = new Hotel("SS Biriyani");

        system.addHotel(hotel1);
        system.addHotel(hotel2);

        hotel1.addReview(new Review("preethi", "Great stay!", 5));
        hotel1.addReview(new Review("Ram", "Not bad", 4));
        hotel1.addReview(new Review("Sam", "Could be better", 3));

        hotel2.addReview(new Review("Dev", "Amazing experience", 5));
        hotel2.addReview(new Review("Priya", "Okayish", 3));

        System.out.println("All reviews for Grand Hotel:");
        for (Review review : hotel1.getReviews()) {
            System.out.println(review);
        }

        System.out.println("\nReviews for Grand Hotel sorted by rating:");
        for (Review review : hotel1.sortReviewsByRating(true)) { 
            System.out.println(review);
        }

        System.out.println("\nReviews for Grand Hotel with rating >= 4:");
        for (Review review : hotel1.filterReviewsByRating(4)) {
            System.out.println(review);
        }
    }
}
