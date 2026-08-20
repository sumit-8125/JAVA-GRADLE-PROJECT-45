Java Gradle CI/CD Automation 🚀

A Java application automated with Gradle, Docker, GitHub Actions, GHCR, and AWS EC2.

The pipeline automatically builds, tests, creates a Docker image, pushes it to GitHub Container Registry, and deploys it to EC2.

🛠️ Technologies
Java 21
Gradle
Docker
GitHub Actions
GitHub Container Registry (GHCR)
AWS EC2
Self-Hosted GitHub Actions Runner
🔄 CI/CD Pipeline
Git Push
   ↓
GitHub Actions
   ↓
Build & Test
   ↓
Docker Image
   ↓
GHCR
   ↓
AWS EC2
   ↓
Docker Container
   ↓
Application :8080
Build Stage

GitHub Actions runs on a GitHub-hosted Ubuntu runner:

Checkout source code
Setup Java 21
Setup Gradle
Build application
Run tests
Build Docker image
Push image to GHCR
Deploy Stage

After a successful build, the deployment job runs on the EC2 self-hosted runner:

GHCR
 ↓
docker pull
 ↓
Stop old container
 ↓
Remove old container
 ↓
Start new container
☁️ AWS EC2

EC2 runs the application using Docker.

Only these components are required on the deployment machine:

EC2
├── Docker
└── GitHub Actions Self-Hosted Runner

Java and Gradle are not required on EC2, because the application is deployed as a Docker image.

📦 Docker Image

The application image is stored in GitHub Container Registry (GHCR).

ghcr.io/<github-owner>/java-gradle-app:latest

The EC2 server pulls this image during deployment.

🚀 Deployment

After pushing code to the main branch:

Developer
   ↓
git push
   ↓
GitHub Actions
   ↓
Build → Test → Docker Build → GHCR Push
   ↓
EC2 Self-Hosted Runner
   ↓
Docker Pull → Docker Run

The application becomes available on:

http://<EC2-PUBLIC-IP>:8080
