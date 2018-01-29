/* We have to monitor both chips and cards. We want to
 * write a program that can request the status of both of
 * these types of hardware and then sends that status over
 * either a TCP/IP connection or via e-mail (SMTP).
 *
 * These messages may be optionally encrypted with
 * either PGP64 bit encryption or PGP128 bit encryption.
 * When sending status out for a card, we want to queue
 * the information to send it out no more than every 10
 * minutes unless there is an error. Chips, on the other
 * hand, send immediately.
 *
 * A configuration file will contain information about which
 * transmission method to use.
 */