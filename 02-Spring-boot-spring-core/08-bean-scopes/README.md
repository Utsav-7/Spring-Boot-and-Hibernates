# Two type of Scope 
- 1. Singleton : Create a single shared instance of the bean by default scope

![Screenshot from 2023-05-11 14-46-59](https://github.com/Utsav-7/Spring-Boot-and-Hibernates/assets/98468952/1cb89b2e-2518-42ce-8f0b-0927908cbc56)


- 2. Prototype : Create new bean instance of each container request
![Screenshot from 2023-05-11 14-47-57](https://github.com/Utsav-7/Spring-Boot-and-Hibernates/assets/98468952/b3c4f8ee-a9ba-4051-a7ac-44dfb57a5d8e)

- Notes: Prototype beans are lazy by default. There is no need to use @Lazy annotation for prototype scopes beans.
