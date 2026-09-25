# Serenity Screenplay Salesforce

UI automation of Salesforce account flows (create and edit an Account) using Serenity BDD with the Screenplay pattern, Cucumber and Selenium WebDriver in Java 17.

![Java](https://img.shields.io/badge/Java-17-ED8B00?logo=openjdk&logoColor=white)
![Serenity BDD](https://img.shields.io/badge/Serenity_BDD-4.1-2E8B57)
![Cucumber](https://img.shields.io/badge/Cucumber-7-23D96C?logo=cucumber&logoColor=white)
![Selenium](https://img.shields.io/badge/Selenium-4.19-43B02A?logo=selenium&logoColor=white)

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

---

Cristian Guerra · Senior SDET · [linkedin.com/in/criguex](https://www.linkedin.com/in/criguex)
