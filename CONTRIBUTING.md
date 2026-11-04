# Contributing to Kitalpha

Thanks for your interest in this project.

## Project description

Conforming with this standard, an MBE workbench is an architecture framework
which aggregates viewpoints clearly separating concerns (e.g., performance,
safety, security, cost). A viewpoint is an engineering extension which comes
with its own metamodels, representations (e.g., diagrams, tables, user
interfaces), rules (e.g., validation, analysis, transformation), services and
tools to address an engineering specialty. Consequently, an MBE workbench is the
result of a flexible assembly of core viewpoints extended by new ones which are,
in the context of co-engineering, appropriate and valuable for specialty
engineers. The set of all the viewpoints defines the complete description of a
system. To build MBE workbenches, designers must be autonomous in creating and
maintaining their own viewpoints, without coding. Developers can enrich them
afterward, for instance for algorithm implementation. To meet this requirement,
Eclipse Kitalpha™ offers a development environment made of DSLs
(Domain-Specific Languages) to assist designers and developers in their
architecture frameworks and viewpoints development activity activities. For
instance, textual editors make it possible to declare viewpoint metamodels, user
interfaces, diagrams, or services. From those DSLs, generators build all the
architecture framework and viewpoint artifacts. For example, the declaration of
diagrams using DSLs becomes the technical description of Sirius diagrams. During
the stages of edition with DSLs and generation, the notion of target application
is introduced to manage the variability of environments in which the artifacts
are to be deployed and executed (e.g., DSL vs. UML, CDO vs. XMI environments).
Figure 1. Development Process Overview   The Kitalpha development environment
also provides MBE core components to develop complete MBE workbenches, for
instance for the functions of import/export (e.g., for data exchange with MBE
workbenches or specialty tools), model transformations with traceability, or
html documentation generation.   Kitalpha potentially has the ability to
implement architecture framework standards (e.g., TOGAF/MODAF) but also
proprietary method or domain workbenches. Figure 2. Illustration of MBE
workbench This rest of this section describes the key features of Kitalpha.
Anatomy of Eclipse Kitalpha Architectural position of Kitalpha Kitalpha can be
considered as a meta-tool. The following picture presents the different working
contexts with regard to Kitalpha. At the top, stakeholders describe a system
architecture, An MBE workbench enables designers to describe system
architecture, Kitalpha is a workbench allows developing and executing MBE
workbenches, Finally, Kitalpha is built atop Eclipse and mainly uses modeling
components. Figure 3. Position of Eclipse Kitalpha Elements of internal
architecture Kitalpha is divided into two layers: An Engineering Layer which is
a set of components and services for developing and executing MBE workbenches.
This layer contains all the architecture framework / viewpoint metamodels, DSLs
with their representations, and services (Cf. section about the Kitalpha
services). A Core Technology Kit (CTK) which is a set of technical components
and frameworks required by the Engineering Layer. The CTK is dedicated to host a
set of added-value technological components which are not provided by Eclipse
components or to adapt existing tools for a specific purpose (e.g., adaptation
of the standard EGF factories). A substantial tool or set of tools can be
grouped in a Kitalpha sub-project for a better partitioning and decoupling of
the sub-components development lifecycles. Precision of the ISO/IEC-42010
standard The ISO/IEC-42010 standard is intentionally general in order to be open
and declined into multiple implementations. The following parts present the
choices made to implement the standard. Kitalpha viewpoint In compliance with
the standard, a Kitalpha architecture framework aggregates viewpoints. A
Kitalpha viewpoint is defined as: A set of metamodels A set of notations (e.g.,
icons) A set of representations (e.g., textual, graphical) A set of rules (e.g.,
check, transformation) A set of services A set of tools Moreover, a viewpoint
inherits and aggregates viewpoints. Eclipse Kitalpha services Kitalpha provides
both development and runtime services to define, use and manage architecture
frameworks and viewpoints. Main services at development time are: For
Architecture Framework (AF): 1) definition of an AF, 2) generation of AF
artifacts, 3) packaging of AF artifacts with the viewpoints it aggregates. For
Viewpoint: 1) definition of a viewpoint, 2) generation of viewpoint artifacts,
3) packaging of viewpoint artifacts. Main services at runtime are: Core
   services: System architecture description with an architecture framework and its
   viewpoints Viewpoint Manager in order to monitor viewpoints Activation /
   Deactivation of a viewpoint Detachment / Attachment of viewpoint data Migration
   of a viewpoint Additional services: Versioning Team Working Reporting
   Architecture Assessment Test Simulation

* https://projects.eclipse.org/projects/polarsys.kitalpha

## Terms of Use

This repository is subject to the Terms of Use of the Eclipse Foundation

* https://www.eclipse.org/legal/termsofuse.php

## Developer resources

Information regarding source code management, builds, coding standards, and
more.

* https://projects.eclipse.org/projects/polarsys.kitalpha/developer

The project maintains the following source code repositories

* https://github.com/eclipse-kitalpha/.github
* https://github.com/eclipse-kitalpha/kitalpha
* https://github.com/eclipse-kitalpha/kitalpha-addons
* https://github.com/eclipse-kitalpha/kitalpha-website

## Eclipse Development Process

This Eclipse Foundation open project is governed by the Eclipse Foundation
Development Process and operates under the terms of the Eclipse IP Policy.

* https://eclipse.org/projects/dev_process
* https://www.eclipse.org/org/documents/Eclipse_IP_Policy.pdf

## Eclipse Contributor Agreement

In order to be able to contribute to Eclipse Foundation projects you must
electronically sign the Eclipse Contributor Agreement (ECA).

* https://www.eclipse.org/legal/ECA.php

The ECA provides the Eclipse Foundation with a permanent record that you agree
that each of your contributions will comply with the commitments documented in
the Developer Certificate of Origin (DCO). Having an ECA on file associated with
the email address matching the "Author" field of your contribution's Git commits
fulfils the DCO's requirement that you sign-off on your contributions.

For more information, please see the Eclipse Committer Handbook:
https://www.eclipse.org/projects/handbook/#resources-commit

## Contact

Contact the project developers via the project's "dev" list.

* https://accounts.eclipse.org/mailing-list/kitalpha-dev
