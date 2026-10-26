# Proposed CRC Cards

Class: Student
Responsibilities: Store student ID, name, and contact details; provide controlled access to student information.
Collaborators: None.

Class: Course
Responsibilities: Store course code and credit hours; provide course information.
Collaborators: None.

Class: Registration
Responsibilities: Represent a student's enrollment in a course and its calculated tuition amount.
Collaborators: Student, Course.

Class: TuitionCalculator
Responsibilities: Calculate tuition using the per-credit rate and heavy-course-load discount rule.
Collaborators: Course.

Class: RegistrationService
Responsibilities: Coordinate registration, request tuition calculation, save the registration, and send confirmation only after successful saving.
Collaborators: Student, Course, Registration, TuitionCalculator, RegistrationRepository, ConfirmationSender, RegistrationLogger.

Class: RegistrationRepository
Responsibilities: Provide a common operation to save a registration record, independent of storage technology.
Collaborators: Registration.

Class: FileRegistrationRepository
Responsibilities: Save registration records to a local file.
Collaborators: RegistrationRepository, Registration.

Class: ConfirmationSender
Responsibilities: Provide a common operation for sending registration confirmations.
Collaborators: Registration, Student.

Class: EmailConfirmationSender
Responsibilities: Send confirmation messages to the student's email address.
Collaborators: ConfirmationSender, Registration, Student.

Class: RegistrationLogger
Responsibilities: Record the time and result of registration processing.
Collaborators: RegistrationService.

These CRC cards describe responsibilities and collaborations; no Java implementation is required for Question 2.
