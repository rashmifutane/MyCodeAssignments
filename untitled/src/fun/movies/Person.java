package fun.movies;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Person {
	private String name;
	private boolean isMale = true;
	Set<Person> friends = new HashSet<>();
	Set<Movie> movies = new HashSet<>();

	public Set<Person> getFriends() {
		return friends;
	}

	public Set<Person> getFriendCircle() {
		Set<Person> circle = new HashSet<>();
		circle.add(this);
		circle.addAll(friends);
		return circle;
	}

	public void makeFriend(Person friend) {
		if (this != friend)
			this.friends.add(friend);
	}

	Person(String name) {
		this.name = name;
	}

	public void addMovie(Movie movie) {
		movies.add(movie);
	}

	public Set<Movie> getMovies() {
		return movies;
	}

	public String getName() {
		return name;
	}

	@Override
	public String toString() {
		return name;
	}

	public List<Movie> getMoviesList() {
		ArrayList ml = new ArrayList<Movie>();
		ml.addAll(getMovies());
		return ml;
	}

}
