/**
 * Wraps low-level I/O failures with a meaningful, domain-specific
 * exception instead of catching (and hiding) generic Exception.
 * Callers can catch this specifically and decide how to respond,
 * rather than errors being silently printed and swallowed.
 */
public class StudentRepositoryException extends Exception {
    public StudentRepositoryException(String message, Throwable cause) {
        super(message, cause);
    }
}
