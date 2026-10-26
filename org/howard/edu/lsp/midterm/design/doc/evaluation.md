# Evaluation of CourseRegistration

The given `CourseRegistration` class has too many responsibilities. It stores student and course information, calculates tuition, applies discounts, prints a confirmation, writes to a file, sends a simulated email, and logs the event. Arthur Riel's heuristic to distribute system intelligence across classes applies here: a single class should not control nearly every part of the system. It also conflicts with the heuristic that a class should capture one key abstraction; this class mixes a registration record with billing, persistence, and communication.

The five public fields allow other code to change student and course data without validation. Making them private and exposing appropriate methods would support encapsulation. The `750.0` tuition rate, `12`-credit threshold, and `0.90` multiplier are embedded in the method, so changes to tuition policy require editing registration processing code. Separating tuition calculation into its own class makes that rule easier to change and test.

The method also depends directly on `FileWriter`, console output, and a hard-coded filename. This tightly couples registration processing to one storage mechanism and one presentation mechanism, making a database or text-message option difficult to introduce. The broad `catch (Exception e)` prints an error but continues to announce a confirmation, even when saving failed. That can produce misleading results. Smaller collaborating classes with clearly defined responsibilities would improve maintainability, extensibility, and correctness.

The evaluation uses the course's CRC responsibility/collaboration approach and Riel's class-responsibility heuristics; exact lecture-slide wording should be checked against the instructor's notes.
