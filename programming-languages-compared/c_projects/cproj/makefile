# Compiler and flags
CC = gcc
CFLAGS = -Wall -Wextra -std=c99 -Iinclude
DEBUG_FLAGS = -g
RELEASE_FLAGS = -O2

# Directories
SRC_DIR = src
OBJ_DIR = obj
BIN_DIR = bin
INC_DIR = include

# Target executable
TARGET = $(BIN_DIR)/myprogram

# Source files (automatically find all .c files in src/)
SOURCES = $(wildcard $(SRC_DIR)/*.c)
OBJECTS = $(SOURCES:$(SRC_DIR)/%.c=$(OBJ_DIR)/%.o)

# Default build (debug)
all: $(TARGET)

# Release build
release: CFLAGS += $(RELEASE_FLAGS)
release: $(TARGET)

# Create executable
$(TARGET): $(OBJECTS) | $(BIN_DIR)
	$(CC) $(OBJECTS) -o $@

# Compile source files
$(OBJ_DIR)/%.o: $(SRC_DIR)/%.c | $(OBJ_DIR)
	$(CC) $(CFLAGS) -c $< -o $@

# Create directories if they don't exist
$(BIN_DIR) $(OBJ_DIR):
	mkdir -p $@

# Clean build artifacts
clean:
	rm -rf $(OBJ_DIR)/*.o $(TARGET)

# Clean everything
distclean: clean
	rm -rf $(BIN_DIR) $(OBJ_DIR)

# Run the program
run: $(TARGET)
	./$(TARGET)

# Debug build
debug: CFLAGS += $(DEBUG_FLAGS)
debug: $(TARGET)

.PHONY: all clean distclean run debug release
