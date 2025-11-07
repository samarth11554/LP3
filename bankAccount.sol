pragma solidity >=0.8.0;

contract BankAccount {
    mapping(address => uint256) private balances;
    mapping(address => bool) private isUser;

    event Deposit(address indexed user, uint256 amount);
    event Withdraw(address indexed user, uint256 amount);

    // Create account with a given initial deposit amount (in wei)
    function createAccount(uint256 initialDepositWei) public {
        require(!isUser[msg.sender], "Account already exists");
        isUser[msg.sender] = true;
        balances[msg.sender] = initialDepositWei;
    }

    // Deposit a specific amount (not actual Ether, just balance update)
    function deposit(uint256 amountWei) public {
        require(isUser[msg.sender], "Account not found");
        require(amountWei > 0, "Deposit must be > 0");
        balances[msg.sender] += amountWei;
        emit Deposit(msg.sender, amountWei);
    }

    // Withdraw amount from balance (simulation only, no Ether transfer)
    function withdraw(uint256 amountWei) public {
        require(isUser[msg.sender], "Account not found");
        require(balances[msg.sender] >= amountWei, "Insufficient balance");
        balances[msg.sender] -= amountWei;
        emit Withdraw(msg.sender, amountWei);
    }

    // Show balance
    function showBalance() public view returns (uint256) {
        require(isUser[msg.sender], "Account not found");
        return balances[msg.sender];
    }
}

