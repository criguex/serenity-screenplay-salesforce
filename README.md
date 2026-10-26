[Leer en español](README.es.md)

<p align="center">
  <img src="docs/assets/banner.svg" alt="serenity-screenplay-salesforce: UI automation of Salesforce account flows where an actor performs tasks and asks questions" width="100%">
</p>

## Explained like you're 8

Imagine a school play. There is a script with the lines, an actor who follows it, things the actor does on stage, and questions the teacher asks at the end to see if the scene went right. This project tests Salesforce, a program companies use to keep track of their customers, the same way: the script is written in plain English, an actor called Cristian logs in and creates a customer account, and then asks "do I see the message that says it was created?".

### A real example

- **Imagine that:** Cristian fills the new-account form with made-up data (name, website, phone, addresses: 14 boxes) and presses Save.
- **What should happen:** Salesforce shows "Se creó Cuenta" ("account created") and opens the new account's page.
- **What the project does:** the actor asks the screen whether that text is there and whether the header, the side bar and the main panel are visible.
- **What we gain:** if saving stopped working, the test would fail with a clear, readable message.

<p align="center">
  <img src="docs/assets/explained.gif" alt="Illustrated story: a script tells the story, the actor Cristian gets a browser, does the tasks one by one, asks whether he sees the success message, and the report keeps a picture of each step" width="960">
</p>

The same animation as [MP4](docs/assets/explained.mp4).

### Hard words

| Word | What it means |
|---|---|
| Screenplay | A way to write tests like a play: actors, tasks and questions |
| Actor | The pretend user who does everything in the test |
| Task | One thing the actor does, like logging in |
| Question | Something the actor checks on the screen |
| Feature file | The script, written in plain English |
| Environment variable | A note the computer keeps outside the code; here, the username and password |

# Serenity Screenplay Salesforce

UI automation of Salesforce account flows (create and edit an Account) using Serenity BDD with the Screenplay pattern, Cucumber and Selenium WebDriver in Java 17.

![Java](https://img.shields.io/badge/Java-17-ED8B00?logo=openjdk&logoColor=white)
![Serenity BDD](https://img.shields.io/badge/Serenity_BDD-4.1-2E8B57)
![Cucumber](https://img.shields.io/badge/Cucumber-7-23D96C?logo=cucumber&logoColor=white)
![Selenium](https://img.shields.io/badge/Selenium-4.19-43B02A?logo=selenium&logoColor=white)

## How it works

<p align="center">
  <img src="docs/assets/how-it-works.svg" alt="Feature files are bound by step definitions to an actor called Cristian who can browse the web with Chrome; the actor performs tasks built on page targets and asks questions whose answers are checked with seeThat, against a Salesforce Lightning org" width="100%">
</p>

1. A Cucumber runner (`CucumberWithSerenity`) picks up `CreateAccount.feature` and `EditAccount.feature`.
2. The step definitions set the stage (`OnlineCast`), call the actor `Cristian` and give it the `BrowseTheWeb` ability on Chrome pointed at `login.salesforce.com`.
3. The actor performs **tasks** (`LoginActions`, `HomeActions`, `CreateAccountActions`, …) built from Serenity interactions (`Click`, `SendKeys`, `Check`, `WaitUntil`) on the **targets** declared in `userinterfaces/`.
4. The actor asks **questions** (`ElementTextValidator`, `ElementVisibilityValidator`) and checks them with `seeThat`; a mismatch is reported through `orComplainWith` and the custom `Exceptions` messages.
5. `mvn verify` aggregates the Serenity report with screenshots and the Screenplay narrative.

<p align="center">
  <img src="docs/assets/how-it-works.gif" alt="Animation: each Gherkin step of CreateAccount.feature is mapped to the Screenplay call it triggers, from login to the seeThat checks and the Serenity report" width="960">
</p>

The animation walks the code path of `CreateAccount.feature` step by step (also as [MP4](docs/assets/how-it-works.mp4)). It is not a recording of a run: there is no CI workflow, so no run results are published in this repository.

## What it tests

| Feature | Scenario | Verifies |
|---|---|---|
| `CreateAccount.feature` | Log in, open Accounts, fill the new-account form and save | Success toast text; account dashboard (header, side bar, main panel) is displayed |
| `EditAccount.feature` | Log in, pick an existing account, edit its details and save | Updated values are displayed in the account details |

Runs against a Salesforce org (Lightning UI) with the credentials you provide; nothing environment-specific is committed.

## Architecture (Screenplay)

- **Actor**: `OnStage` / `OnlineCast` with the `BrowseTheWeb` ability on a configured Chrome instance.
- **Tasks** (`task/`): `LoginActions`, `HomeActions`, `CreateAccountActions`, `SelectAcccountToEditActions`, `EditAccountActions`; business-level interactions composed of Serenity `Click`, `SendKeys`, `Check` and `WaitUntil`.
- **Questions** (`questions/`): `ElementTextValidator` and `ElementVisibilityValidator` read state from the UI for `seeThat` assertions.
- **User interfaces** (`userinterfaces/`): `Target` definitions per page (`LoginPage`, `HomePage`, `AccountPage`, `SpecificAccountPage`).
- **Step definitions** (`stepdefinitions/`): bind Gherkin steps to tasks and questions; custom `Exceptions` produce readable failure messages through `orComplainWith`.
- **Utilities** (`utils/`): driver factory, constants, login data, random test data and assertion data.

## How to run

Requires JDK 17, Maven 3.x and Google Chrome (the driver is resolved by Selenium Manager).

Credentials are read from the `SF_USERNAME` and `SF_PASSWORD` environment variables (or `-D` system properties); the suite fails fast with a clear message if they are missing. See `.env.example`.

```bash
git clone https://github.com/criguex/serenity-screenplay-salesforce.git
cd serenity-screenplay-salesforce

export SF_USERNAME="your.user@example.com"
export SF_PASSWORD="your-password"
export HEADLESS=true                              # optional, default false

mvn clean verify                                  # all features + Serenity report
mvn clean verify -Dtest=RunCreateAccountFeature   # single feature
mvn clean verify -Dtest=RunEditAccountFeature
```

## Project structure

```
.
├── .env.example
├── docs/
│   ├── assets/        banner.svg, how-it-works.*, explained.* (kids' animation, EN + .es)
│   └── scenes/        how-it-works.html, explained.html + their export scripts
├── pom.xml
├── serenity.properties
└── src/
    ├── main/java/test/accountsalesforce/
    │   ├── exceptions/       Exceptions
    │   ├── questions/        ElementTextValidator, ElementVisibilityValidator
    │   ├── task/             LoginActions, HomeActions, CreateAccountActions, EditAccountActions, ...
    │   ├── userinterfaces/   LoginPage, HomePage, AccountPage, SpecificAccountPage
    │   └── utils/            drivers, constants, data, randomdata, assertiondata
    └── test/
        ├── java/test/accountsalesforce/
        │   ├── runner/           RunAllFeatures, RunCreateAccountFeature, RunEditAccountFeature
        │   └── stepdefinitions/  CreateAccountStepDefinitions, EditAccountStepDefinitions
        └── resources/features/   CreateAccount.feature, EditAccount.feature
```

## Reporting

`mvn verify` runs the Serenity Maven plugin after the tests and writes the aggregated report to `target/site/serenity/` (`index.html`, plus a single-page HTML version) with step-by-step screenshots, timings and the Screenplay narrative for each scenario.

## CI

No workflow is configured: the suite needs a live Salesforce org and credentials, so it is meant to run locally or from a pipeline that injects `SF_USERNAME` and `SF_PASSWORD` as secrets.

## Limits

- It needs a live Salesforce org and valid credentials; without them the login task stops with a clear message.
- `EditAccount.feature` picks a random account from the Accounts list, so the org needs at least one account.
- Form data is random on every run, so runs are not byte-for-byte repeatable.

## Rebuilding the animation

`docs/scenes/how-it-works.html` draws each frame from `?t=<seconds>`; `docs/scenes/export.sh` captures the frames with headless Chrome and encodes `how-it-works.gif` and `how-it-works.mp4` with ffmpeg. `docs/scenes/explained.html` (`?t=<seconds>&lang=en|es`) and `docs/scenes/export-explained.sh` do the same for the kids' animation.

---

Cristian Guerra · Senior SDET · [linkedin.com/in/criguex](https://www.linkedin.com/in/criguex)
