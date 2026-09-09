class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next

class Linked_List:
    def __init__(self):
        self.head = None

    def build_from_list(self, values):
        """Takes a Python list and returns the head of the linked list."""
        if not values:
            return None

        self.head = ListNode(values[0])
        current = self.head

        for val in values[1:]:
            current.next = ListNode(val)
            current = current.next

        return self.head

    def print_list(self, head=None):
        """Utility to print linked list values for debugging."""
        if head is None:
            head = self.head

        current = head
        result = []
        while current:
            result.append(str(current.val))
            current = current.next
        print(" -> ".join(result))