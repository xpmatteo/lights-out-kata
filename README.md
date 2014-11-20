# The Lights Out Kata

The goal of this exercise is to learn how to test-drive HTML user interfaces in Java.

Lights Out is a simple puzzle.  In this version of the puzzle, there is a 3x3 grid that looks like this:

    1 1 1
    1 1 1
    1 1 1

The elements of the grid can change state from 1 to 0 and from 0 to 1.

Whenever you click on a number, that element and the ones above, below, right and left of it change state.  For instance, if I click on the center element, the grid becomes

    1 0 1
    0 0 0
    1 0 1

And if I then click on the top left element, the grid becomes

    0 1 1
    1 0 0
    1 0 1

The object of the game is to set all the elements to 0.

# Instructions

## Import the project in Eclipse with

    mvn eclipse:clean eclipse:eclipse -DdownloadSources -DdownloadJavadocs

## Import the project in Idea with

    mvn idea:idea

## Run the application with

    mvn package -DskipTests=true
    script/run.sh
    open http://localhost:8080


# Quickstart

The goal of this kata is to learn how to test-drive a user interface.  At the start, there is a WebDriver-based end-to-end test that sets the goal for the kata.  It's unlikely that you can make it pass in 5 minutes, so it's best to `@Ignore` the end-to-end test at first and concentrate on smaller tests.

It's possible to solve this entirely in JavaScript and you are welcome to do so.  However, if you want to learn how to test-drive HTML GUIs in Java, I suggest you do the following.

## Start with a trivial version of the puzzle

The first thing you should try to do is to solve a simpler, trivial version of the puzzle where you toggle only the element you click.  Forget about its neighbours for the moment.

## Test drive the template

Look at what happens inside the LigthsOutServlet.  There is an object called TemplateView that allows you to easily render a FreeMarker template.  Your goal is to test-drive that template.

There is a test `LightsOutViewTest` that renders the index.ftl template into a string and then parses the string with the help of the `HtmlDocument` class.  You can then query the `HtmlDocument` with XPath queries.  You first test should be to prove that if you can change the numbers rendered by putting values into the `TemplateView`

## After you've implemented the 3x3 puzzle

After the simple version of the puzzle works, you may up the difficulty by adding the requirement that if a parameter ?size=N is provided, then the grid should become NxN




