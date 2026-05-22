# 🌐 Web UI Test Automation Architecture

<p align="left">
  <a href="https://oracle.com">
    <img src="https://shields.io"/>
  </a>
  <a href="https://selenium.dev">
    <img src="https://shields.io"/>
  </a>
  <a href="https://cucumber.io">
    <img src="https://shields.io"/>
  </a>
  <a href="https://apache.org">
    <img src="https://shields.io"/>
  </a>
</p>

---

## 🚀 Overview

A production-grade **Web UI Automation Framework** engineered to execute robust, end-to-end regression testing on enterprise web platforms. 

Built with **Java SE**, **Selenium WebDriver**, and **Cucumber (BDD)**, this repository implements architectural patterns designed to simulate complex user journeys, manage multi-browser execution layers, and provide automated execution logging with high-fidelity validation evidence.

🎯 Focus: **Cross-browser regression testing, behavioral test alignment, and visual execution verification for high-scale web infrastructures.**

---

## 🎯 Key Technical Features

- 🏗️ **Page Object Model (POM) Design:** Structural decoupling of application UI locators and DOM element interactions from the step definition test assertions.
- 🥒 **Gherkin Feature Specifications:** Clear business-to-technical mapping of user acceptance criteria using behavior-driven development principles.
- ⏱️ **Synchronization & Wait Strategies:** Custom implementation of Selenium Explicit and Fluent Waits to handle AJAX/dynamic DOM rendering and eliminate test flakiness.
- 📋 **Automated Evidence Compilation:** Native generation of execution run logs and detailed transactional verification evidence (PDF logs).

---

## 🏗️ Project Architecture Layout

The testing engine splits operational responsibilities across clean layers:

```text
AtomatizacionWeb/
│
├── QAInnovationLab-automation-web/
│   ├── src/
│   │   ├── main/java/pages/       # Page Object Layer (DOM selectors & web interactions)
│   │   └── test/
│   │       ├── java/
│   │       │   ├── runner/        # Test suite hooks and execution configurations
│   │       │   └── steps/         # Step Definition mappings connecting Gherkin to Java
│   │       └── resources/
│   │           └── features/      # Business-readable user stories (.feature files)
│   │
│   └── pom.xml                    # Maven engine dependency manifest
│
├── EVIDENCIA1.pdf                 # Certified execution test run validation report
└── README.md                      # Technical engineering documentation
```

---

## 📊 Impact (CV-Level Highlights)

- ⚡ **Highly Maintainable Test Base:** Designed a highly scaling Page Object Model structure, reducing framework updating efforts by centralizing DOM mapping objects.
- 📉 **Mitigated Test Flakiness:** Implemented smart wait conditions to handle heavy asynchronous page elements, dropping execution script errors drastically.
- 🤝 **Engineered for Agile Cadence:** Formulated test structures ready to run automated web checks immediately after frontend code updates in active Scrum loops.
- 📊 **Audit-Ready Evidence:** Structured test reporting configurations that generate production execution PDF footprints for operational compliance verification.

---

## ⚙️ Installation & Test Execution

### 1. Environment Requirements
- **Java SE Development Kit (JDK 11 or higher)**
- **Apache Maven 3.8+**
- Active Google Chrome or Mozilla Firefox installation with updated local WebDriver drivers.

### 2. Project Bootstrapping
```bash
git clone https://github.com
cd AtomatizacionWeb/QAInnovationLab-automation-web
```

### 3. Build Manifest & Dependency Verification
```bash
mvn clean install
```

### 4. Execute the Regression Suites
```bash
mvn test
```

---

## 🔐 Engineering Best Practices Applied

- **Targeted DOM Locators:** Web elements use optimized, fast-resolving CSS Selectors and Relative XPaths, avoiding fragile absolute locator paths.
- **Assertion Isolation:** Validation checkpoints (`Assert`) are strictly localized inside step classes, leaving Page Objects focused on DOM interactions.
- **State Cleanup Hooks:** Employs systematic `@Before` and `@After` hooks to control the browser driver lifecycle, wiping active storage cookies between loops.

---

## 👨‍💻 Author

**Victor Guzmán**  
*Computational Scientist | Backend Engineer | Software Quality & Test Automation Specialist*  
- 🔗 **LinkedIn:** [https://linkedin.com](https://www.linkedin.com/in/victor-h-guzm%C3%A1n-a19361187/)
