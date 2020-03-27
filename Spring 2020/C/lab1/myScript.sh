# Problem Statement: "Often I have to search for different files and directories within my computer system. 
#                     In order to do this I use the 'ls' command to help orient myself.
# Name of command: ls
# Example of its usage: None
# -bash-4.2$ ls
# Lab1  README.md

# Here is the myScript.sh script that can list the directories and how many total directories are in the current folder.
# usage: sh myScript.sh

echo "These are the current files in the directory:"
ls
echo
echo "The amount of files in the directory is:"
ls | wc -l
echo
# I wanted to try something unqiue even though its pretty simple to ask for a name and output it to make it seem as though the computer is human like.
# Name of command: None
# Example of its usage : None
# Lab1 README.md

# This is the myScript.sh script that can ask for the users name and respond by saying hello back.
# usage: sh myScript.sh

echo "Hello, who am I talking to?"
read varname
echo "Its nice to meet you" $varname
echo

# Problem Statement: "Sometimes, I wonder if a folder contains a specific file or another folder within it. In order to do this, I would have to go into the directory and ls to see if the file or folder is in it."
# Name of command: C-x C-f
# Example of its usage:
# Lab1 README.md

# This is the myScript.sh script that can ask for the user to provide a file or folder name that they are looking for and return a statement of it is is in the current folder. It will also catch if the input is invalid.
# usage: sh myScript.sh

echo -n "Please enter a folder or file to search for: "
read folder

if [[ -d $folder ]] ; then
    echo "$folder is a directory";
else
    if [[ -f $folder ]] ; then
	echo "$folder is a file";
    else
	echo "The folder or file you are looking for is not valid.";
    fi
fi
echo

#·Problem·Statement:·"Sometimes,·I·would like to make a new folder to contain new files. In order to do this, I would have to run a command.
# Name of command: mkdir
# Example of its usage:
# Lab1 README.md

# This is the myScript.sh script that can ask the user if they would like to make a new directory.It·will·also·catch·if·the·input·is·invalid.$
# usage: sh myScript.sh$

echo -n -e "Would you like to make a new directory? Yes/No?\n"
read yn
if [[ $yn = "Yes" ]] ; then
       echo -n -e "What would you like to call it?\n";
       read dirname
       mkdir $dirname;
else
    if [[ $yn = "No" ]] ; then
	 echo "Thank you for your response, I will not make a new directory.";
    else
	echo "Your input is invalid, I will not make a new directory.";
    fi
fi
echo

#·Problem·Statement:·"Sometimes,·I·would·like·to·copy a folder from the resources folder. ·In·order·to·do·this,·I·would·have·to·go into the resources folder and run a command.
# Name of command: cp
# Example of its usage:
# Lab1 README.md

# This is the myScript.sh script that can ask the user if they would like to copy a folder from the resources folder.
# usage: sh myScript.sh

echo "Would you like to copy a folder from the resources folder?"
echo -n -e "Yes/No?\n"
read copy
if [[ $copy = "Yes" ]] ; then
    echo -n -e "What is the name of the folder?\n"
    read foldername
    cp -r ~/cs5007/resources/$foldername ~/cs5007/arealjones_CS5006/lab1
else
    if [[ $copy = "No" ]] ; then
	echo "Thank you for your response, I will not copy any folders.";
    else
	echo "Your input is invalid, I will not copy any folders.";
    fi
fi
