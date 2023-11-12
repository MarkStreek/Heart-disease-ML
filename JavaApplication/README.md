<a name="readme-top"></a>

[![LinkedIn][linkedin-shield]][linkedin-url]
[![Issues][issues-shield]][issues-url]
[![Forks][forks-shield]][forks-url]

<br />
<div align="center">
  <a href="https://github.com/github_username/repo_name">
    <img src="https://upload.wikimedia.org/wikipedia/en/thumb/3/30/Java_programming_language_logo.svg/1024px-Java_programming_language_logo.svg.png" alt="Logo" width="80" height="80">
  </a>
<h3 align="center">Predicting a heart disease using clinical attributes</h3>
  <p align="center">
    This repository contains a Java wrapper where a heart disease can be predicted, using clinical attributes.
    <br />
    <a href="https://github.com/MarkStreek/PredictingHeartDiseaseJavaWrapper"><strong>Explore the docs »</strong></a>
    <br />
    <br />
    <a href="https://github.com/MarkStreek/PredictingHeartDiseaseJavaWrapper">View Demo</a>
    ·
    <a href="https://github.com/MarkStreek/PredictingHeartDiseaseJavaWrapper/issues">Report Bug</a>
    ·
    <a href="https://github.com/MarkStreek/PredictingHeartDiseaseJavaWrapper/issues">Request Feature</a>
  </p>
</div>

<details>
  <summary>Table of Contents</summary>
  <ol>
    <li>
      <a href="#about-the-project">About The Project</a>
    </li>
    <li>
      <a href="#installation">Installation</a>
    </li>
    <li><a href="#usage">Usage</a></li>
    <li><a href="#contact">Contact</a></li>
  </ol>
</details>

## About The Project

In this repository, you can find a project about predicting a heart disease. The predicting is done by a created machine learning model. In this project, the creation of the model is not being handeled. This is done in a earlier [project](https://github.com/MarkStreek/Heart-disease-ML).

The application that predicts the disease was build in Java using the [Java Weka API](https://weka.sourceforge.io/doc.stable/). The user can give up a input file and select the requested output. Without defining a output option, the classified instances are being printed to the console.

Application options

- -f,--filename: Name of input file
- -w,--writingOut: Name of the output file
- -a,--areaUnderAOC: Get the area under AOC (only available when classlabels are given)
- -m,--confusionMatrix: Show the confustion Matrix of the predictions (only available when classlabels are given)

Project structure:

<pre>
├── gradlew
├── gradlew.bat
├── settings.gradle
└── src
   └── main
       ├── java
       │   └── ClassifierHeartDisease
       │       ├── AreaUnderAOC.java
       │       ├── Classify.java
       │       ├── CommandLineParsing.java
       │       ├── ConfusionMatrix.java
       │       ├── Controlling.java
       │       ├── LoadingModelData.java
       │       ├── LoadingUserData.java
       │       ├── Main.java
       │       ├── UserFeedback.java
       │       └── WritingOutput.java
       └── resources
           └── Stacking_Heart_Disease_Model.model
</pre>

<p align="right">(<a href="#readme-top">back to top</a>)</p>


## Installation

First of all, this project must be downloaded and needs to be unpacked. After the project lives inside a directory, the folowing steps must be complete for a smooth run:

1. Java must be installed on the system you're using!
2. There MUST be a file called: '**BFVPredictingHeartDisease1.0.jar**'
3. An input file with data is needed. This file must be a .arff file

> Inside this project there is a file called **template.arff**. Inside this file, the user can classify up to a single instance. This is placed inside a file, because otherwise the user needs to declare 11 attributes variabels via the commandline. *Open this file with an editor (for example: notepad) and follow the instructions in this file.*

<p align="right">(<a href="#readme-top">back to top</a>)</p>


## Usage

After the important steps are completed, you can now run the program. Because it's a java program, you have to start with calling java. You can call the help of the program, simply by calling the program without any options.

Open a new terminal inside this directory (or on mac: open a new terminal and navigate to this directory with *cd*). Type the following command to get the help:

```bash
java -jar BFVPredictingHeartDisease1.0.jar
```

You can now read the help. For example, if you want to make a prediction based on your own .arff file and write the output to a new .arff file, the following command can be used (your file must be in the same directory as the project):

```bash
java -jar BFVPredictingHeartDisease1.0.jar -f yourOwnFileName.arff -w yourOwnOutputFileName
```

The options for the confusion matrix and area under the curve, only can be used, when the class labels are given. For example, you can use these options to train new data. 

<p align="right">(<a href="#readme-top">back to top</a>)</p>


## Contact

In case of trouble, please contact the owner of the project:

Mark van de Streek - [@mail](mailto:m.van.de.streek@st.hanze.nl) - m.van.de.streek@st.hanze.nl

Project Link: [https://github.com/MarkStreek/PredictingHeartDiseaseJavaWrapper](https://github.com/MarkStreek/PredictingHeartDiseaseJavaWrapper)

<p align="right">(<a href="#readme-top">back to top</a>)</p>

[issues-shield]: https://img.shields.io/github/issues/MarkStreek/PredictingHeartDiseaseJavaWrapper.svg?style=for-the-badge
[issues-url]: https://github.com/MarkStreek/PredictingHeartDiseaseJavaWrapper/issues

[linkedin-shield]: https://img.shields.io/badge/-LinkedIn-black.svg?style=for-the-badge&logo=linkedin&colorB=555
[linkedin-url]: https://www.linkedin.com/in/mark-van-de-streek-0a2b29232

[forks-shield]: https://img.shields.io/github/forks/MarkStreek/PredictingHeartDiseaseJavaWrapper.svg?style=for-the-badge
[forks-url]: https://github.com/MarkStreek/PredictingHeartDiseaseJavaWrapper/members
