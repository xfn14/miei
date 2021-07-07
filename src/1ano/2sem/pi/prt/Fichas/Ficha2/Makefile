PROGRAM_NAME = prog

OBJECT_FILES = main.o
CFLAGS = -O2 -Wall -g

$(PROGRAM_NAME) : $(OBJECT_FILES)
		gcc $(CFLAGS) -o $@ $(OBJECT_FILES)

$(PROGRAM_NAME).o : $(PROGRAM_NAME).c
		gcc $(CFLAGS) -c $<

clean :
		$(RM) $(PROGRAM_NAME)
		$(RM) $(OBJECT_FILES)
