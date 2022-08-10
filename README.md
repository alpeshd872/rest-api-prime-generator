# Prime Number Generator
Calculates prime numbers in the range between two given numbers.

## Usage

### Command line
<p align="left">
  <img src="/img/cmdexe.PNG" width="400px" height="300px" >
</p>

### Instructions for Web Server
Requirement:
1. IDE : Intellij, Eclipse, Spring suit(I have used this).
2. PostMan

### REST API
Note:- Remove Img and Core folder no need for that 
1. Start the Webserver Java application

2. Open PostMan
>localhost:8080/primeserver/{methods}/{lowerBound}/{UpperBound}

3. The server will respond with the following JSON formatted data:
>[2,3,5,7,11,13,17,19,23,29,31,37,41,43,47,53,59,61,67,71,73,79,83,89,97]

