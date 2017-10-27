# CS305 – Software Engineering

## Practice Midterm

# Part 2: Theory [40 points]

This is part 2 of the midterm exam. It has 17 questions.

This file is named `Theory-Questions.md`. Provide the answers in this file and commit the file to the `master` branch of this `midterm-GASPAR` repo. Do not change the name of the file, and do not change the existing text unless otherwise indicated.
For multiple-choice questions, we marked the choices as `[]`; you should change each one to `[y]` for all correct (yes) choices and to `[n]` for all incorrect (no) choices.
Checkboxes left empty will indicate you did not answer that question, so please be careful. Do not introduce extraneous spaces, as that will cause you to lose points.

### Question 1

Which of the following is _not_ a sign of software complexity?

- [ ] Large number of methods
- [ ] Large number of small components
- [ ] Large number of component interactions


### Question 2

Which of the following exceptions should be checked? (multiple answers may be possible)

- [ ] A request to a server that times out
- [ ] A database query that attempts to retrieve data from a non-existent table
- [ ] A user enters an invalid email address when signing up on a website
- [ ] Your application requests a resource using a deprecated version of the API.


### Question 3

Which of the following is true about using the Scrum Agile development to develop an application?

- [ ] It allows you to eliminate code comments because only a small team is responsible for the code. This allows the team to move faster.
- [ ] Team members may come from different backgrounds (e.g. Android developers, AppEngine server developers, and data scientists can be on the same team).
- [ ] The Scrum master helps maximize the business value of the application by prioritizing the customer’s interests.
- [ ] The Daily Scrum is used to resolve any blocking issues that team members experience in the current sprint.


### Question 4

Which of the following is _always_ true about test-driven development (TDD)? (multiple answers may be possible)

- [ ] All tests must pass for a feature to be considered complete.
- [ ] It is a good practice for designing the “look and feel” of your application (e.g. button sizes, fonts).
- [ ] It is useful for developing new features on a large, legacy application.
- [ ] Tests should not be discarded after the feature is implemented.


### Question 5

Your application may receive garbage input if it does which of the following? (multiple answers may be possible)

- [ ] Reads a file
- [ ] Writes a file
- [ ] Reads data from its own memory that it has previously written to memory
- [ ] Has a command line interface


### Question 6

Which of the following are appropriate circumstances for adopting strict adherence to the waterfall method? (multiple answers may be possible)

- [ ] Creating a new feature in an open source database (e.g. MySQL, Postgres) that is used by large companies.
- [ ] Developing an operating system for an interstellar spacecraft
- [ ] Building the Gotthard Base Tunnel
- [ ] Creating a new Android application at a company with a large number of users (e.g. Facebook, Twitter).


### Question 7

Under which circumstances should you let a runtime exception abnormally terminate your application? (multiple answers may be possible)

- [ ] A divide-by-0 calculation
- [ ] A connection to a server times out when requesting a resource.
- [ ] A user specifies an incorrect command line argument.
- [ ] Not being able to load a necessary external library for your application.


### Question 8

What would be the downsides of choosing a scrum development model when building a new CPU? (multiple answers may be possible)

- [ ] The frequent feedback from scrum can be very distracting when designing a complicated system.
- [ ] The design and requirements must be in place before starting the development process due to the difficulty of replacing millions of defective CPUs if customers discover an error.
- [ ] The cost of making a change to a mature prototype is very high.
- [ ] Breaking down the project into small features for small scrum teams is not possible.


### Question 9

Your Android app communicates with several servers, some of which return XML while others return JSON. Which design pattern is most appropriate for writing the code to parse the servers’ responses?

- [ ] Observer
- [ ] Factory
- [ ] Decorator
- [ ] Singleton


### Question 10

Which of the following is true about software testing? (multiple answers may be possible)

- [ ] Tests are useful for refactoring.
- [ ] Testing proves that covered code has no bugs only if the tests pass.
- [ ] An application that has 100% testing coverage is bug-free.
- [ ] Tests can help identify if a “solved” bug reappears in a later iteration of the code (“regression” bugs).


### Question 11

What is wrong with this Java interface?

```
public interface Stack<T> {
    public int getIndexOfTopItem();
    public void incrementTopItemIndex();
    public void pushItemAtFirstIndex(T item, int firstIndex);
    public T getItemAtFirstIndex(int firstIndex);
}
```

- [ ] The interface should be a class instead.
- [ ] The stack index should be a generic index, so it doesn’t limit the interface.
- [ ] The interface exposes too much internal complexity, breaking the abstraction layer.
- [ ] The interface should inherit from other interfaces to be more usable.


### Question 12

You are tasked with modifying code a coworker wrote years ago. The code does not match your preferred coding style. You should…

- [ ] Write code that matches the old code’s style.
- [ ] Reformat the whole file to your coding style.
- [ ] Leave the old code alone, but use the new format on lines of code that you change.
- [ ] Do whatever you want, it’s old code anyway.


### Question 13

Which of the following are appropriate uses of an issue tracker (e.g. GitHub Issues on your project repositories) for a given server application called `InventoryServer`? (multiple answers may be possible)

- [ ] Storing documentation about the API of `InventoryServer` for external developers.
- [ ] Tracking new features for `InventoryServer`
- [ ] Tracking user interface bugs in `InventoryApp`, an Android app that communicates with `InventoryServer`
- [ ] Assigning issues to team members so everyone knows who is responsible for each piece of functionality.


### Question 14

When should you ask other members of your team to review your code?

- [ ] After everybody has finished their task for the sprint
- [ ] After finishing every method you need to write
- [ ] After finishing one chunk of functionality
- [ ] Never; the other members should take the initiative to review it.


### Question 15

You are in a team of 4 people that have to collaborate in the code in a git repository. What are some practices _to avoid_? (multiple answers may be possible)

- [ ] have everyone in the team work on their own branch
- [ ] have some people working directly on master and some others on dedicated branches
- [ ] keep all branches in sync with master (e.g. by merging)
- [ ] merging features branches into other features branches before either has been merged to master


### Question 16

Why would you use pull requests? (multiple answers may be possible)

- [ ] to ease peer reviewing
- [ ] to keep the code clean and tidy
- [ ] to be able to see changes before merging these into master
- [ ] because this is the only way to put changes into the master branch
- [ ] because, you know, I was told to, but I don’t really know what it is...

### Question 17

Choose the best set of variable names:

- [ ] i, errs, c, a
- [ ] i, errors, complete, alpha
- [ ] i, numErrors, isRequestComplete, alpha
- [ ] index, numberOfErrorsReceivedFromDatabaseServer, isRequestCompleteYet, angleForRotationInRadians
