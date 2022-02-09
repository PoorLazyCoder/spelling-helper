# spelling-helper
Help ESL english students to spelling and write an essay, Can search the words that student cannot spell. It requires java to run.     
Dic file has 29,000 words,
Wiki file has 150,000 words,
It uses color highlight to show matched letters.    
This is the demo https://koooe.github.io/s_helper

##
S is start letter.
M is letters at middle, and follow order.
L is letters at middle, but not follow order.
E is end letter.

Use color highlight, to show color

![hight light](https://user-images.githubusercontent.com/98500513/153254611-1b487b81-432b-4a73-aebe-3b36e05ac338.JPG)


##

Example 1 : I don't know how to spell "furniture"    
I only know the word start with "f", end with "ure", and its length more than 8

start "f"   
end "ure"   
length > 8    

![ex_1](https://user-images.githubusercontent.com/98500513/153248560-daf6b851-7874-4f5a-acfd-61347813b844.jpg)

##

Example 2: "plagiarism"   
start : p    
end : ism   
length > 10   

![ex_2](https://user-images.githubusercontent.com/98500513/153248725-44625410-027d-49c0-b860-dd3557c7b5aa.jpg)

##

Example 3: "refrigerator"     
start : r    
end : r
contain letter : f   
length > 8    

![ex_3](https://user-images.githubusercontent.com/98500513/153248783-41891a0b-6a6f-4e21-8b10-d7dc07fccde6.jpg)


##
Example 4: "raccoon"   
start : r   
contain string : oo   

![ex_4](https://user-images.githubusercontent.com/98500513/153249039-f7001790-0182-4bae-a729-d25b938a9ea2.jpg)


##
Example 5 : Regular expression
I don't know how to spell "suffer"
I only know it starts with "su", and follow two letters, and end with "er"



![ex_5](https://user-images.githubusercontent.com/98500513/153249175-565186a1-ec92-49c9-96a0-a8a329225f89.jpg)

 
# Online version

![sc1](https://user-images.githubusercontent.com/98500513/153249589-976efcd5-b80a-49b0-8f7d-81ac46dc0b02.png)

![sc2](https://user-images.githubusercontent.com/98500513/153249600-87187061-024e-4eb0-aa14-a92374fee55f.png)

![sc3](https://user-images.githubusercontent.com/98500513/153249613-8b636261-ffea-4427-a768-2fd075bfd634.png)


# For Developer

The project uses JDK8 and NetBeans IDE 12.6, The Main Class is desktop.DesktopUi.java.             
The Online version only run on server, for example  https:// localhost/. The Online version's source code is outdate, and no longer be can compiled, so it is not included.

![netbeans](https://user-images.githubusercontent.com/98500513/153250444-1c7da43e-1af3-445d-b670-d96468c3d882.png)




