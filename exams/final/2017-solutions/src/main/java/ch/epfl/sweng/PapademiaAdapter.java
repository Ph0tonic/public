package ch.epfl.sweng;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Adapter from Papademia to Poodle.
 */
public final class PapademiaAdapter {
    private final List<PapademiaUser> users;
    private final List<PapademiaCourse> courses;

    public PapademiaAdapter(final List<PapademiaUser> users, final List<PapademiaCourse> courses) {
        if (users == null) {
            throw new IllegalArgumentException("Users cannot be null");
        }
        if (courses == null) {
            throw new IllegalArgumentException("Courses cannot be null");
        }

        this.users = Collections.unmodifiableList(new ArrayList<>(users));
        this.courses = Collections.unmodifiableList(new ArrayList<>(courses));
    }

    /**
     * Gets the users as Poodle users.
     */
    public List<User> getUsers() {
        // This method is extremely simple since Poodle users have only a name
        // Note that we don't need to care about preserving referential equality
        // (i.e. having the same instance for the same user)
        // since User implements equals in a way that only checks for the name
        // thus we can just `new User(...)` each time
        return users.parallelStream().filter(Objects::nonNull).map(x -> x.name).map(User::new).collect(Collectors.toList());
    }

    /**
     * Gets the courses as Poodle courses.
     */
    public List<Course> getCourses() {
        // This method is more involved
        // But it is fundamentally the same logic as the Homepage.
        // Same remark as in `getUsers` regarding referential equality.
        return courses.parallelStream().filter(Objects::nonNull).map(c ->
                new Course(c.name,
                        users.parallelStream().filter(u -> u.taughtCourses.contains((c))).map(u -> u.name).map(User::new).collect(Collectors.toList()),
                        users.parallelStream().filter(u -> u.attendedCourses.contains((c))).map(u -> u.name).map(User::new).collect(Collectors.toList())
                )
        ).collect(Collectors.toList());
    }
}
