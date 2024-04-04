class Node:
    def __init__(self, data):
        self.data = data
        self.left = None
        self.right = None

def insertData(root, data):
    if root is None:
        return Node(data)
    if data <= root.data:
        root.left = insertData(root.left, data)
    else:
        root.right = insertData(root.right, data)
    return root

def takeInput():
    root = None
    while True:
        data = int(input("Enter data (or -1 to stop): "))
        if data == -1:
            break
        root = insertData(root, data)
    return root

def levelOrderTraversal(root):
    if root is None:
        return

    queue = []
    queue.append(root)

    while queue:
        current = queue.pop(0)
        print(current.data, end=" ")
        if current.left:
            queue.append(current.left)
        if current.right:
            queue.append(current.right)

if __name__ == "__main__":
    root = takeInput()
    print("Level Order Traversal:", end=" ")
    levelOrderTraversal(root)
