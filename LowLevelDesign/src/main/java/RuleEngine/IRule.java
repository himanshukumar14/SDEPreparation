package RuleEngine;

import java.util.List;

public interface IRule {
    Object execute(List args);
}
