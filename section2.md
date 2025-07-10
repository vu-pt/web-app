## 🐳 **Docker CLI Exercises**

### 1. **Hello World Container**
```bash
docker run hello-world
```
✅ *Goal:* Verify Docker is installed and working.

---

### 2. **Run a Web Server (e.g., Nginx)**
```bash
docker run -d -p 8080:80 nginx
```
✅ *Goal:* Run Nginx in the background and access it via `http://localhost:8080`.

---

### 3. **List Running Containers**
```bash
docker ps
```

### 4. **List All Containers (including stopped)**
```bash
docker ps -a
```

---

### 5. **Build a Custom Image**
Create a file named `Dockerfile`:
```Dockerfile
FROM alpine
CMD ["echo", "Hello from custom image!"]
```
Then build and run:
```bash
docker build -t my-hello .
docker run my-hello
```

---

### 6. **Mount a Volume**
```bash
docker run -v $(pwd):/data alpine ls /data
```
✅ *Goal:* Share files between host and container.

---

## 🧩 **Docker Compose Exercises**

### 1. **Simple Web + Redis Stack**

Create a `docker-compose.yml`:
```yaml
version: '3'
services:
  web:
    image: nginx
    ports:
      - "8080:80"
  redis:
    image: redis
```

Run it:
```bash
docker-compose up -d
```

Check services:
```bash
docker-compose ps
```

Stop and remove:
```bash
docker-compose down
```

---

### 2. **Build from Dockerfile with Compose**

Add a `Dockerfile`:
```Dockerfile
FROM alpine
CMD ["echo", "Built with Compose!"]
```

Then update `docker-compose.yml`:
```yaml
version: '3'
services:
  app:
    build: .
```

Run:
```bash
docker-compose up
```

---

# Exercises
## 1. Create a web container with Docker Command
- Create a NGINX container with a web page (index.html) showing "hello docker" text
* Verify: Can access http://localhost:8080 and see content
- Change index.html it effect immediately. (Using ### 6. Mount a Volume)
* Verify change index.html file and reload the page.
## 2. Create a web container with Docker Compose command
Do exercise #1 with Docker Compose
