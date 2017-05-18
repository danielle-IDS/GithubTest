# dince@georgefox.edu
# 2016-10-19
# Program 7

runAgain = True
while runAgain:
    
    # Get inputs
    
    speed = int(input("Please enter the car's speed (in mph): "))
    hours = int(input("Please enter the number of whole hours the car traveled: "))
    
    # Error trap for negative values
    
    while speed < 0:
        print("***Please enter a positive speed***")
        speed = int(input("Please enter the car's speed (in mph): "))
    while hours < 0:
        print("***Please enter a positive speed***")
        hours = int(input("Please enter the number of whole hours the car traveled: "))
    
    # For loop for calculating and displaying output 
    
    print("Hour", format("Distance Traveled", ">20"))
    print("-"*25)
    for i in range(1, hours + 1):
        distance = speed * i
        print(i, format(distance, '>15'))
    
    #Ask user to run again
    userResponse = input("Do you want to run this program again? (Y/N): ")
    if userResponse == "Y" or userResponse == "y":
        reunAgain = True
    else:
        print("Have a nice day!")
        runAgain = False



# use for loops
# you use the number of hours for the amount of times that you loop
# 
# if runAgain == "Y" or runAgain == "y"
# only test for these 2, everything else doesn't get run