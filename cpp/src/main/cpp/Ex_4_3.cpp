#include "Ex_4_3.hpp"

#include <algorithm>
#include <cassert>

int Ex_4_3::max(const std::list<int>& elements) {
  assert(!elements.empty());
  int head = elements.front();
  std::list<int> tail({std::next(elements.begin()), elements.end()});
  if (tail.empty()) {
    return head;
  }
  return std::max(head, this->max(tail));
}