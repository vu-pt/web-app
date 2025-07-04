# GIT command line

## Preparation
- Fork the repo to your personal account click on below link
https://github.com/vu-pt/web-app/fork
- Clone your repo
``` shell
git clone https://github.com/<your-personal-github-profile-name>/web-app
```
Example: my repo's profile name is ```vu-pt```

## Task 1: create branch and push to remote repo

``` shell
git checkout training
git branch feature/task/test1
git checkout feature/task/test1
echo 'Complete task 1' > git-task1.done
git add git-task1.done
git commit -m $'TASK 1: create branch and push to remote repo \n\n [Add] git task1 done file'
git push origin feature/task/test1
```

## Task 2: Rebase branch and push to remote repo

``` shell
git checkout training
git branch feature/task/test2
git checkout feature/task/test2
echo 'Task 2 change line' > README.md
echo 'Complete task 2' > git-task2.done
git add git-task2.done README.md
git commit -m $'TASK 2: Rebase branch and push to remote repo \n\n [Add] git task2 done file\n[Update] update README.md'
git rebase feature/task/test1
git push origin feature/task/test2
```

## Task 3: Fix conflict code
``` shell
git checkout training
git branch feature/task/test3
git checkout feature/task/test3
echo $'\nTask 3 change line' >> README.md
git add README.md
git commit -m $'TASK 3: Fix conflict code \n\n[update] change file README.md'
git rebase feature/task/test2
# conflict happens like: CONFLICT (content): Merge conflict in README.md
```
Use vim or IDEA/code editor to fix
````
<<<<<<< HEAD
Task 2 change line
=======
### Build application
```
docker-compose build
```
### Start application
```
docker-compose up -d
```
### Stop application
```
docker-compose down
```
Task 3 change line
>>>>>>> d81abdb (TASK 3: Fix conflict code)
````
Change to
````
Task 2 change line
### Build application
```
docker-compose build
```
### Start application
```
docker-compose up -d
```
### Stop application
```
docker-compose down
```
Task 3 change line
````
Run next command to confirm the fix
``` shell
git add README.md
git rebase --continue
# message commit is opened 
# type `:wq` to continue
git push origin feature/task/test3